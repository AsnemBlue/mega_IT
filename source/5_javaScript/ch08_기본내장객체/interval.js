// interval.js (Date객체에 두시점을 날짜 계산하는 getInterval함수 추가)
// JavaScript source code
Date.prototype.getInterval = function (otherday) {
    if (this > otherday) {
        var intervalMilli = this.getTime() - otherday.getTime();
    } else {
        var intervalMilli = otherday.getTime() - this.getTime();
    }
    var intervalDay = Math.floor(intervalMilli / (1000 * 60 * 60 * 24));
    return intervalDay;
};
