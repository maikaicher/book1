function processInput() { 
    if (u_zahl < z_zahl) {
        setInfoText("zu klein");
    } else {
        if (u_zahl > z_zahl) {
            setInfoText("zu groß");
        } else {
            setInfoText("richtig");
        }
    }
}