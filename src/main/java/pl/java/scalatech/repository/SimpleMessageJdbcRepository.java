package pl.java.scalatech.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.basic.SimpleMessage;

@Slf4j
public class SimpleMessageJdbcRepository {

    public void readSimpleMessage() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<SimpleMessage> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb?username=sa");
            ps = connection.prepareStatement("SELECT id, text FROM SimpleMessages");
            rs = ps.executeQuery();
            while (rs.next()) {
                SimpleMessage SimpleMessage = new SimpleMessage();
                SimpleMessage.setId(rs.getLong(1));
                SimpleMessage.setText(rs.getString(2));
                list.add(SimpleMessage);
            }

            for (SimpleMessage m : list) {
                log.info("message : {}", m);
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ignored) {
            }
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ignored) {
            }
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ignored) {
            }
        }
    }
}
