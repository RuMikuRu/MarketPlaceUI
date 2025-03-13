package core;

import java.sql.*;

public final class DataBaseCore {
    private String DB_URL = "jdbc:postgresql://77.221.159.98:5430/postgres_db";
    private String DB_DRIVER = "org.postgresql.Driver";

    private static Connection conn;

    public final Connection getConn() {
        return conn;
    }

    public final boolean connectionDB(String username, String password) {
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, username, password);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public final void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public final void callProcedure(String procName) {
        try {
            CallableStatement statement = conn.prepareCall("{ call " + procName + "()}");
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public final ResultSet callProcedureWithParam(String procName, Object... params) {
        StringBuilder callString = new StringBuilder("{ call " + procName + "(");
        callString.append("?,".repeat(params.length));
        if (params.length > 0) {
            callString.deleteCharAt(callString.length() - 1);
        }
        callString.append(")}");

        try {
            CallableStatement statement = conn.prepareCall(callString.toString());
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            return statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при вызове процедуры " + procName, e);
        }
    }
}
