export default class MyLogger {
    constructor() {
        if (new.target === MyLogger) {
            throw TypeError("Error!");
        }
    }

    doLog(data) {
        throw TypeError("Error!");
    }
}



