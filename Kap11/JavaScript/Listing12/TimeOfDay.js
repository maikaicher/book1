printTimeOfDay(16);

function printTimeOfDay(h) { 
    if (h < 7) {
      console.log("nachts");
    } else if (h < 11) {
      console.log("morgens");
    } else if (h < 13) {
      console.log("vormittags");
    } else if (h < 15) {
      console.log("mittags");
    } else if (h < 18) {
      console.log("nachmittags");
    } else if (h < 22) {
      console.log("abends");
    } else { 
      console.log("nachts");
    }
  }
  