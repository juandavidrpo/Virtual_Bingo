const mongoose = require('mongoose');
const bcrypt = require('bcrypt-nodejs');
const { Schema } = mongoose;

/**
 * Representa el Schema del registro
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo
 */
const userSchema = new Schema({
    email: String,
    password: String,
});

userSchema.methods.encryptPass = (password) => {
    return bcrypt.hashSync(password, bcrypt.genSaltSync(5));
};

userSchema.methods.comparePass = function (password) {
    return bcrypt.compareSync(password, this.password);
};

module.exports = mongoose.model('users', userSchema);
