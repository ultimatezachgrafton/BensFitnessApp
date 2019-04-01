package database;

// The class that defines the database parameters

public class ReportDbSchema {
    public static final class ReportTable {
        public static final String NAME = "reports";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String DATE = "date";
            public static final String CLIENT = "client";
        }
    }
}