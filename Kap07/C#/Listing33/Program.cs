Dictionary<string, string> cfgValues = new Dictionary<string, string>();
cfgValues.Add("IP", "127.0.0.1");
cfgValues.Add("PORT", "3306");
cfgValues.Add("DBType", "MYSQL");
Console.WriteLine("Cnct: " + cfgValues["IP"] + ":" + cfgValues["PORT"]);
