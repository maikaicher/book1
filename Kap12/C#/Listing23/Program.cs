int iFlags = 0;
iFlags |= 0b1;        // setze Bit auf Position 0
iFlags |= 0b10000;    // setze Bit auf Position 4
iFlags |= 0b10000000; // setze Bit auf Position 7
checkFlags(iFlags);

static void checkFlags(int iFlags) {
  int mask = 1;
  for (int i = 0; i < 32; i++) {
    if ((iFlags & mask) != 0) {
      Console.WriteLine("Bit " + i + " ist 1");
    }
    mask <<= 1;
  }
}

