const admin = require('firebase-admin');
const serviceAccount = require('./dv508-webshop-firebase-adminsdk.json');
const products = require('./products.json');
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL:
    'https://console.firebase.google.com/u/0/project/dv508-webshop/database/firestore/data~2F',
});

const db = admin.firestore();

function randomInt(low, high) {
  return Math.floor(Math.random() * (high - low) + low);
}

function createCategory(category) {
  db.collection('categories')
    .add({
      imageUrl: category.imageUrl,
      name: category.category,
      searchName: category.category.toLowerCase(),
      topic: category.topic,
      url: category.category.replace(/\s+/g, '-').toLowerCase(),
    })
    .then(ref => {
      console.log('Added document with ID: ', ref.id);
      db.collection('categories')
        .doc(ref.id)
        .update({
          id: ref.id,
        })
        .then(() => {
          console.log(ref.id, '=>', 'updated');
          category.categoryId = ref.id;
          createProducts(category);
        })
        .catch(function(error) {
          console.log('Error updating doc:', error);
        });
    });
}
function createProducts(category) {
  // console.log(category);
  category.productList.forEach(product => {
    if (product !== null) {
      const quantity = randomInt(1, 10);
      db.collection('products')
        .add({
          categoryId: category.categoryId,
          title: product.title,
          searchName: product.title.toLowerCase(),
          url: product.title.replace(/\s+/g, '-').toLowerCase(),
          coverImage: product.coverImage,
          description: product.description,
          price: product.price,
          discountPrice: product.discountPrice,
          images: product.images,
          isDayDeal: false,
          quantity: quantity,
          isTestData: true,
        })
        .then(ref => {
          console.log('Added document with ID: ', ref.id);
          db.collection('products')
            .doc(ref.id)
            .update({
              id: ref.id,
            })
            .then(() => {
              console.log(ref.id, '=>', 'updated');
            })
            .catch(function(error) {
              console.log('Error updating doc:', error);
            });
        });
    }
  });
}
function seedProductData() {
  products.categories.forEach(category => {
    if (category.categoryId === '') {
      createCategory(category);
    } else {
      createProducts(category);
    }
  });
}

console.log('==========Starting Seed of Product Data==========');
seedProductData();
