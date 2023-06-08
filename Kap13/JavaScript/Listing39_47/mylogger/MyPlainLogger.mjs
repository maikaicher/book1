import MyLogger from "./MyLogger.mjs";

export default class MyPlainLogger extends MyLogger {
    constructor() {
        super();
    }

    doLog(data) {
        console.log(data);
    }
}