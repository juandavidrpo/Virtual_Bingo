const express = require('express');
const res = require('express/lib/response');
const router = express.Router();

const passport = require('passport');

router.get('/', (req, res, next) => {
    res.render('index');
});

router.get('/signup', (req, res, next) => {
    res.render('signup');
});

router.post(
    '/signup',
    passport.authenticate('local-signup', {
        successRedirect: '/bingo',
        failureRedirect: '/signup',
        passReqToCallback: true,
    })
);

router.get('/signin', (req, res, next) => {
    res.render('signin');
});

router.post(
    '/signin',
    passport.authenticate('local-signin', {
        successRedirect: '/bingo',
        failureRedirect: '/signin',
        passReqToCallback: true,
    })
);

router.get('/logout', (req, res, next) => {
    req.logout();
    res.redirect('/');
});

//autentica que el usuario este logeado para poder ver las paginas
router.use((req, res, next) => {
    isAuthenticated(req, res, next);
    next();
});

router.get('/bingo', (req, res, next) => {
    res.render('bingo');
});

function isAuthenticated(req, res, next) {
    if (req.isAuthenticated()) {
        return next();
    }
    res.redirect('/');
}

module.exports = router;
