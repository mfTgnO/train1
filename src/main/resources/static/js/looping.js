var obj =
    {
        a: 'value1',
        b: 'value2',
        c: 'value3',
        d: 'value4'
    };
for (var prop in obj) {
    obj[prop] = 'xxx';
}

console.log("hello world");