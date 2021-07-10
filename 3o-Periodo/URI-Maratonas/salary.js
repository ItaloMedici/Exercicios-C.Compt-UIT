var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var id = parseFloat(lines.shift());
var hrs = parseFloat(lines.shift());
var slr = parseFloat(lines.shift());
var salary = parseFloat((slr * hrs));

console.log(`NUMBER = ${id}\nSALARY = U$ ${salary.toFixed(2)}`);