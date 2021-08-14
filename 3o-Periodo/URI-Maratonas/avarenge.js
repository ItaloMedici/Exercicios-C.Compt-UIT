/* var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var n1 = parseFloat(lines.shift());
var n2 = parseFloat(lines.shift()); */

var n1 = 5.0;
var n2 = 7.1;

var md = parseFloat(((n1 + n2) / 2));

console.log(`MEDIA = ${md.toFixed(5)}\n`);