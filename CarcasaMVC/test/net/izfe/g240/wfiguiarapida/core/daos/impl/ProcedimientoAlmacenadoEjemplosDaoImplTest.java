package net.izfe.g240.wfiguiarapida.core.daos.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import net.izfe.g240.wfiguiarapida.core.daos.ProcedimientoAlmacenadoEjemplosDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/net/izfe/g240/wfiguiarapida/core/config/applicationContext.xml",
"classpath:/net/izfe/g240/wfiguiarapida/core/config/applicationContext-test.xml" })
@Transactional
public class ProcedimientoAlmacenadoEjemplosDaoImplTest {

	@Autowired ProcedimientoAlmacenadoEjemplosDao procedimientoAlmacenadoEjemplosDao;
	
	@Test(expected = DataRetrievalFailureException.class)
	public void getContribuyenteNumiError() {
		procedimientoAlmacenadoEjemplosDao.getContribuyenteNumi("B20152203", "TROYMEC S");
	}
	
	@Test
	public void getContribuyenteNumi() {
		String numi = procedimientoAlmacenadoEjemplosDao.getContribuyenteNumi("08902894P", "TALAVERA PEREZ HIPOLITO");
		
		assertNotNull(numi);
		assertEquals("0000358801", numi);
	}
	
}
