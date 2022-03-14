/**
 * Representa el servidor.
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo.
 */
const express = require('express');
const app = express();
const engine = require('ejs-mate');
const path = require('path');
const morgan = require('morgan');
const passport = require('passport');
const session = require('express-session');
const flash = require('connect-flash');

require('./database');
require('./passport/authentication');

/**
 * Represneta la configuracion del servidor.
 */
app.set('views', path.join(__dirname, 'views'));
app.engine('ejs', engine);
app.set('view engine', 'ejs');
app.set('port', process.env.PORT || 3000);

/**
 * Representa los middlewares
 */
app.use(morgan('dev'));
app.use(express.urlencoded({ extended: false }));
app.use(
    session({
        secret: 'mysecretsession',
        resave: false,
        saveUninitialized: false,
    })
);
app.use(flash());
app.use(passport.initialize());
app.use(passport.session());
app.use((req, res, next) => {
    app.locals.signupMessage = req.flash('signupMessage');
    app.locals.signinMessage = req.flash('signinMessage');
    app.locals.user = req.user;
    next();
});

/**
 * Representa la ruta inicial.
 */
app.use('/', require('./routes/index'));

/**
 * Representa la inicialización del servidor.
 */
app.listen(app.get('port'), () => {
    console.log('Server on port', app.get('port'));
});

app.listen();
