package com.ma.dao.impl;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.dialect.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ma.beans.Trabajador;
import com.ma.mappers.TrabajadorRowMapper;

import jakarta.annotation.PostConstruct;

@Repository
public class TrabajadorDaoImpl extends GenericDao {

	    public void insertarTrabajador(Trabajador trabajador) {
	        SimpleJdbcCall call = new SimpleJdbcCall(getJdbcTemplate())
	        		.withCatalogName("pkg_trabajadores")
	                .withProcedureName("SP_INSERTAR_TRABAJADOR");

	        Map<String, Object> params = new HashMap<>();
	        params.put("p_nombre", trabajador.getNombre());
	        params.put("p_apellido", trabajador.getApellido());
	        params.put("p_email", trabajador.getEmail());
	        params.put("p_telefono", trabajador.getTelefono());
	        params.put("p_edad", trabajador.getEdad());

	        call.execute(params);
	    }
	    
		public Trabajador buscarPorIdTrabajador(Integer id) {
			SimpleJdbcCall call = new SimpleJdbcCall(getJdbcTemplate())
	            .withProcedureName("SP_BUSCAR_TRABAJADOR")
	            .declareParameters(
	                new SqlParameter("p_id", Types.INTEGER),
	                new SqlOutParameter("p_result", OracleTypes.CURSOR,
	                    new TrabajadorRowMapper()) // necesitas un RowMapper
	            );

	    Map<String, Object> params = new HashMap<>();
	    params.put("p_id", id);

	    Map<String, Object> result = call.execute(params);

	    // "p_result" es el cursor devuelto
	    @SuppressWarnings("unchecked")
		List<Trabajador> lista = (List<Trabajador>) result.get("p_result");

	    return lista.isEmpty() ? null : lista.get(0); 
		}
}
