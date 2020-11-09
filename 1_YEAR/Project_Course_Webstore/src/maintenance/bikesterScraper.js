const rp = require('request-promise');
const $ = require('cheerio');
const fs = require('fs');
const sleep = require('system-sleep');

const POUNDS_TO_SEK = 12.51;
const NUM_PRODUCTS_PER_CATEGORY = 30;

const products = require('./categories.json');
console.log('==========Starting Scraper ==========');
scrape();

let totalCallbacks = 0;
let callbackCount = 0;
function validate(s) {
  var rgx = /^[0-9]*\.?[0-9]*$/;
  return s.match(rgx);
}
function scrapeProducts(url, index, productIndex) {
  rp(url)
    .then(function(html) {
      callbackCount++;
      //success!
      const titleLookup = $('h1', html);
      const title = titleLookup.text().trim();

      const priceLookup = $('.js-productPriceContainer', html);
      const price = priceLookup.find('span:contains("£")').text();
      const discount = priceLookup.find('div:contains("£")').text();

      const descriptionLookup = $('.productDescription', html);
      const pDescription = descriptionLookup.find('div > p').text();
      const divDescription = descriptionLookup.find('div > div').text();
      let description = '';
      const mainImageLookup = $('.mainImage', html);
      const mainImage = mainImageLookup[0].attribs.src;

      const priceTrim = price.replace(/ /g, '');
      let priceVal = '';
      for (let i = 0; i < priceTrim.length; i++) {
        if (validate(priceTrim[i])) {
          priceVal += priceTrim[i];
        }
      }
      const discountTrim = discount.replace(/ /g, '').replace(/,/g, '');
      let discountVal = ['', ''];
      let discountIndex = 0;
      for (let i = 0; i < discountTrim.length; i++) {
        if (validate(discountTrim[i])) {
          discountVal[discountIndex] += discountTrim[i];
          if (!validate(discountTrim[i + 1])) {
            discountIndex++;
            if (discountIndex > 1) {
              break;
            }
          }
        }
      }
      if (priceVal === '') {
        priceVal = discountVal[0];
      }
      priceVal = (parseInt(priceVal) * POUNDS_TO_SEK).toFixed(2);
      discountVal = (parseInt(discountVal[1]) * POUNDS_TO_SEK).toFixed(2);

      if (pDescription === '') {
        description = divDescription;
      } else {
        description = pDescription;
      }

      products.categories[productIndex].productList[index] = {
        title: title,
        description: description,
        price: priceVal,
        discountPrice: discountVal,
        coverImage: {
          imagePath: 'path',
          imageUrl: mainImage,
        },
        images: [
          {
            imagePath: 'path',
            imageUrl: mainImage,
          },
        ],
      };
      callBacksFinished();
    })
    .catch(function(err) {
      console.log(err);
      writeFile();
      //handle error
    });
}
function scrapeCategory(url, productIndex) {
  rp(url)
    .then(function(html) {
      //success!
      const productLookup = $('.js-galleryProductLink', html);
      // const length = productLookup.length;
      const length = NUM_PRODUCTS_PER_CATEGORY;
      totalCallbacks += length;
      for (let i = 0; i < length; i++) {
        const href = productLookup[i].attribs.href;
        console.log(href);
        sleep(250);

        scrapeProducts(href, i, productIndex);
      }
    })
    .catch(function(err) {
      console.log(err);
      //handle error
    });
}
function scrape() {
  for (let i = 0; i < products.categories.length; i++) {
    console.log(products.categories[i].url);
    scrapeCategory(products.categories[i].url, i);
  }
}
function callBacksFinished() {
  console.log('Next Product:', callbackCount, 'Total Products', totalCallbacks);

  if (callbackCount >= totalCallbacks - NUM_PRODUCTS_PER_CATEGORY) {
    writeFile();
  }
}
function writeFile() {
  fs.writeFile(
    'src/maintenance/products.json',
    JSON.stringify(products, null, 4),
    function() {
      console.log(
        'File successfully written! - Check your project directory for the products.json file'
      );
    }
  );
}
