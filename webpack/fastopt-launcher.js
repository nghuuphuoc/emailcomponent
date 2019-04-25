const fastOpt = require('./email-fastopt.js');
fastOpt.main();
module.exports = fastOpt;

if (module.hot) {
    module.hot.accept();
}
