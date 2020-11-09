const functions = require('firebase-functions');
const admin = require('firebase-admin');
const nodemailer = require('nodemailer');
const cors = require('cors')({ origin: true });
admin.initializeApp();
const db = admin.firestore();

exports.sendEMail = functions.https.onRequest((req, res) => {
  cors(req, res, () => {
    const transporter = nodemailer.createTransport({
      service: 'gmail',
      auth: {
        user: 'alexbeattie2@gmail.com',
        pass: 'B3att13Al3x',
      },
    });

    console.log(req.body);
    const mailOptions = {
      from: 'Bikeshop <alexbeattie2@gmail.com>',
      to: req.body.data.body.to,
      subject: req.body.data.body.subject,
      html: req.body.data.body.text,
    };

    transporter.sendMail(mailOptions, (error, info) => {
      if (error) {
        console.log(error);
        res.sendStatus(500);
      } else {
        console.log(`Message sent to: ${req.body.data.body.to}`);
        res.sendStatus(200);
      }
      transporter.close();
    });
  });
});

exports.aggregateRatings = functions.firestore
  .document('products/{productId}/ratings/{ratingId}')
  .onWrite((change, context) => {
    // Get value of the newly added rating
    var ratingValue = Number(change.after.data().rating);

    // Get a reference to the product
    var productRef = db.doc(`products/${context.params.productId}`);

    // Update aggregations in a transaction
    return db.runTransaction(transaction => {
      return transaction.get(productRef).then(productDoc => {
        // Compute new number of ratings
        var newNumRatings = Number(productDoc.data().numRatings) + 1;

        // Compute new average rating
        var oldRatingTotal =
          Number(productDoc.data().avgRating) *
          Number(productDoc.data().numRatings);
        var newAvgRating = (oldRatingTotal + ratingValue) / newNumRatings;

        // Update product info
        return transaction.update(productRef, {
          avgRating: newAvgRating,
          numRatings: newNumRatings,
        });
      });
    });
  });
