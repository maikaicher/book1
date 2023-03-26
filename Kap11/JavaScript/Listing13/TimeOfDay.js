printTimeOfDay(16);

function printTimeOfDay(h) { 
  switch(true) {
    case (h < 7):
      console.log("nachts");
      break;
    case (h < 11):
      console.log("morgens");
      break;
    case (h < 13):
      console.log("vormittags");
      break;
    case (h < 15):	
      console.log("mittags");
      break;
    case (h < 18):
      console.log("nachmittags");
      break;
    case (h < 22):
      console.log("abends");
      break;
    default: 
      console.log("nachts");
  }
}

  