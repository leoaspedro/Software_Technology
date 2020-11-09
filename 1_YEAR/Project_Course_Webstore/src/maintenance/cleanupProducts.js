const admin = require('firebase-admin');
const serviceAccount = require('./dv508-webshop-firebase-adminsdk.json');
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL:
    'https://console.firebase.google.com/u/0/project/dv508-webshop/database/firestore/data~2F',
});

const db = admin.firestore();
function cleanUpProducts() {
  const dbProducts = db.collection('products');
  dbProducts.get().then(products => {
    products.forEach(doc => {
      const data = doc.data();
      if (data.isTestData === true) {
        dbProducts
          .doc(doc.id)
          .delete()
          .then(() => {
            console.log(doc.id, '=>', 'deleted from db');
          })
          .catch(function(error) {
            console.log('Error deleting user:', error);
          });
      }
    });
  });
}

console.log('==========Starting Cleanup of Products==========');
cleanUpProducts();
