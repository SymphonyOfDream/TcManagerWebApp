package com.davidlowe.tcmanagerwebapp.models;


import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RolesTypeHandler implements TypeHandler<Roles>
{
    @Override
    public void setParameter(PreparedStatement ps, int i, Roles parameter, JdbcType jdbcType)
            throws SQLException
    {
        if (parameter == null) {
            ps.setNull(i, java.sql.Types.TINYINT);
        } else {
            ps.setInt(i, parameter.getId());
        }
    }

    @Override
    public Roles getResult(ResultSet rs, String columnName)
            throws SQLException
    {
        return Roles.get(rs.getByte(columnName));
    }

    @Override
    public Roles getResult(ResultSet rs, int columnIndex)
            throws SQLException
    {
        return Roles.get(rs.getByte(columnIndex));
    }

    @Override
    public Roles getResult(CallableStatement cs, int columnIndex)
            throws SQLException
    {
        return Roles.get(cs.getByte(columnIndex));
    }
}
