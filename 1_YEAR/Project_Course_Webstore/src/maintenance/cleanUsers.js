const admin = require('firebase-admin');
const serviceAccount = require('./dv508-webshop-firebase-adminsdk.json');
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL:
    'https://console.firebase.google.com/u/0/project/dv508-webshop/database/firestore/data~2F',
});
const db = admin.firestore();
function cleanUpUsers() {
  cleanUpAuth();
  cleanUpDbUsers();
}
function cleanUpDbUsers() {
  const dbUsers = db.collection('users');
  dbUsers.get().then(users => {
    users.forEach(doc => {
      const data = doc.data();
      if (data.email.includes('@mymail.test')) {
        dbUsers
          .doc(doc.id)
          .delete()
          .then(() => {
            console.log(data.email, '=>', 'deleted from db');
          })
          .catch(function(error) {
            console.log('Error deleting user:', error);
          });
      }
    });
  });
}
function cleanUpAuth() {
  // List batch of users, 1000 at a time.
  admin
    .auth()
    .listUsers(1000)
    .then(function(listUsersResult) {
      listUsersResult.users.forEach(function(userRecord) {
        // console.log('User email: ' + userRecord.email);
        if (userRecord.email.includes('@mymail.test')) {
          admin
            .auth()
            .deleteUser(userRecord.uid)
            .then(function() {
              console.log(userRecord.email, '=>', 'deleted from auth');
            })
            .catch(function(error) {
              console.log('Error deleting user:', error);
            });
        }
      });
    })
    .catch(function(error) {
      console.log('Error listing users:', error);
    })
    .then(() => {
      // end();
    });
}
function end() {
  console.log('==========Ending Cleanup==========');
  process.exit();
}
console.log('==========Starting Cleanup==========');
cleanUpUsers();
