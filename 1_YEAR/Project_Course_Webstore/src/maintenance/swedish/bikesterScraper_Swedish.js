const rp = require('request-promise');
const $ = require('cheerio');
const fs = require('fs');
const sleep = require('system-sleep');

// const BASE_HREF = 'https://www.bikester.se/';
// const BIKE_HREF = BASE_HREF + 'cyklar/';
const NUM_PRODUCTS_PER_CATEGORY = 30;

const products = require('../categories.json');
console.log('==========Starting Scraper ==========');
scrape();

let totalCallbacks = 0;
let callbackCount = 0;
function scrapeProducts(url, index, productIndex) {
  rp(url)
    .then(function(html) {
      callbackCount++;
      //success!
      const titleLookup = $('h1', html);
      const title = titleLookup.text().trim();

      const priceLookup = $('.js-productPriceContainer', html);
      const price = priceLookup.find('span:contains("kr")').text();
      const discount = priceLookup.find('div:contains("kr")').text();

      const descriptionLookup = $('.productDescription', html).find('div > p');
      const description = descriptionLookup.text();

      const mainImageLookup = $('.mainImage', html);
      const mainImage = mainImageLookup[0].attribs.src;

      const priceTrim = price.replace(/ /g, '');
      let priceVal = '';
      for (let i = 0; i < priceTrim.length; i++) {
        if (!isNaN(priceTrim[i])) {
          priceVal += priceTrim[i];
        }
      }
      const discountTrim = discount.replace(/ /g, '');
      let discountVal = ['', ''];
      let discountIndex = 0;
      for (let i = 0; i < discountTrim.length; i++) {
        if (!isNaN(parseInt(discountTrim[i]))) {
          discountVal[discountIndex] += discountTrim[i];
          if (isNaN(parseInt(discountTrim[i + 1]))) {
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
      priceVal = parseInt(priceVal);
      discountVal = parseInt(discountVal[1]);
      // console.log("Price: ", priceVal);
      // console.log("Discount: ",discountVal);

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
      // console.log("index", index, "length",length,"callbackCnt",callbackCount);
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
      // console.log(products.electricBike);
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
