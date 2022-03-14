/**
 * Representa la configuración de la base de datos.
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo.
 */
const mongoose = require('mongoose');
const { mongodb } = require('./keys');

mongoose
    .connect(mongodb.URI)
    .then((db) => console.log('Database is connected'))
    .catch((err) => console.log(err));
