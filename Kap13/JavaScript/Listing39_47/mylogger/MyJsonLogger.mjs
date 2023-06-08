import MyLogger from "./MyLogger.mjs";

export default class MyJsonLogger extends MyLogger {
    constructor() {
        super();
    }

    doLog(data) {
        console.log("{\"message\":\"" + data + "\"}");
    }
}