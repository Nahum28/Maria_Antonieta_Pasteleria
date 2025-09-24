package com.ma.dao.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ma.beans.VentaKaiExcel;
import com.ma.dao.ExcelKaiDao;

@Repository
public class ExcelKaiDAoImpl extends GenericDao implements ExcelKaiDao {

	@Override
	public void insertar(List<VentaKaiExcel> ventas) {
        String sql = "{call MA_EXCEL_TABLAS.INSERTAR_EXCEL_KAI(?,?,?,?,?,?,?,?,?,?,?)}";

        getJdbcTemplate().batchUpdate(sql, ventas, 1000, (ps, venta) -> {
            System.out.println(venta);
        	String fechaStr = venta.getFecha();  // "17/09/2024 14:18"
        	fechaStr = fechaStr.replace("\"", ""); // Elimina las comillas
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        	LocalDateTime fecha = LocalDateTime.parse(fechaStr, formatter);
        	
        	ps.setString(1, venta.getId());
        	ps.setObject(2, fecha); // Utiliza setObject con LocalDateTime
            ps.setInt(3, Integer.parseInt(venta.getTotalItems()));
            ps.setInt(4, Integer.parseInt((venta.getSubtotal()).replace(".","").replace(",","")));
            ps.setDouble(5, Double.parseDouble(venta.getDescuento()));
            ps.setInt(6, Integer.parseInt(venta.getEnvio()));
            ps.setDouble(7, Double.parseDouble((venta.getTotal()).replace(".","").replace(",","") .replaceAll("[^0-9,.-]", "")));
            ps.setDouble(8, Double.parseDouble((venta.getGanancia()).replace(",", ".")));
            ps.setString(9, venta.getFormaPago());
            ps.setString(10, venta.getCliente());
            ps.setString(11, venta.getObservacion());
        });
	}

}
