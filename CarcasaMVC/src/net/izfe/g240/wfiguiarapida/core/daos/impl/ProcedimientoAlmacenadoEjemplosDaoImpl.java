package net.izfe.g240.wfiguiarapida.core.daos.impl;

import java.sql.Types;
import java.util.Map;

import net.izfe.g240.wfiguiarapida.core.daos.ProcedimientoAlmacenadoEjemplosDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class ProcedimientoAlmacenadoEjemplosDaoImpl implements ProcedimientoAlmacenadoEjemplosDao {

	private static final int CODIGO_ERROR_LENGTH = 3;
	
	private static final String CODIGO_CORRECTO = "100";
	
	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("WATPA07")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(
						new SqlParameter("DB2PEN01", Types.VARCHAR),
						new SqlParameter("DB2PEN02", Types.VARCHAR),
						new SqlOutParameter("DB2PSA03", Types.VARCHAR)
				);
	}
	
	@Override
	public String getContribuyenteNumi(String dni, String nombre) {
		Map<String, Object> result = simpleJdbcCall.execute(dni, nombre);
		
		String value = (String) result.get("DB2PSA03");
		
		if (hasErrors(value)) {
			throw new DataRetrievalFailureException("El resultado no ha devuelto el código correcto");
		}
		
		return value.substring(CODIGO_ERROR_LENGTH);
	}
	
	private boolean hasErrors(String value) {
		String codigo = value.substring(0, CODIGO_ERROR_LENGTH);
		return !CODIGO_CORRECTO.equalsIgnoreCase(codigo);
	}

}
