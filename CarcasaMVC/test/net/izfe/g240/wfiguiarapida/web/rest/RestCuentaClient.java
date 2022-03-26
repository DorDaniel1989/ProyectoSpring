package net.izfe.g240.wfiguiarapida.web.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.beans.Idioma;
import net.izfe.g240.wfiguiarapida.core.beans.Perfil;
import net.izfe.g240.wfiguiarapida.web.beans.CuentasWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestCuentaClient {
	
	private static final int LIST_SIZE = 3;

	private static final Logger LOGGER = LoggerFactory.getLogger(RestCuentaClient.class);

	public static void main(String[] args) throws Exception {

		// Llamar al servicio REST con Java puro
		consumoREST();

		// Llamar al servicio REST con las utilidades de Spring
		consumoConSpring();
	}

	/**
	 * Ejemplo de consumo de un servicio REST usando clases de la propia JDK
	 */
	private static void consumoREST() {

		try {

			URL restServiceURL = new URL("http://localhost:9080/WAS/HACI/WFIGuiaRapidaSpringMVCWEB/api/cuentas/prueba1");

			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("Accept", "application/xml");

			if (httpConnection.getResponseCode() != 200) {
				LOGGER.info("REST: Error code: {}", httpConnection.getResponseCode());
			}

			BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));

			String output;
			StringBuilder result = new StringBuilder();

			while ((output = responseBuffer.readLine()) != null) {
				result.append(output);
			}

			LOGGER.info("REST: Result: {}", result);

			httpConnection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ejemplo de consumo de un servicio REST usando la clase de Spring RestTemplate para facilitar la llamada y consumo
	 * del resultado
	 * @throws URISyntaxException 
	 */
	private static void consumoConSpring() throws URISyntaxException {

		// Cargar ApplicationContext para el cliente REST
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/net/izfe/g240/wfiguiarapida/web/rest/applicationContext-rest-client.xml");

		// Obtener instancia de RestTemplate
		RestTemplate template = context.getBean(RestTemplate.class);

		Cuenta cuenta = template.getForObject(
				"http://localhost:9080/WAS/HACI/WFIGuiaRapidaSpringMVCWEB/api/cuentas/{cuentaId}", Cuenta.class, "prueba_nulos");

		LOGGER.info("REST: Nombre de cuenta: {}", cuenta.getNombre());

		CuentasWrapper cuentas = template.getForObject(
				"http://localhost:9080/WAS/HACI/WFIGuiaRapidaSpringMVCWEB/api/cuentas", CuentasWrapper.class);
		
		LOGGER.info("REST: Numero de cuentas: {}", cuentas.getCuentas().size());
		
		
		URI uri = new URI("http://localhost:9080/WAS/HACI/WFIGuiaRapidaSpringMVCWEB/api/cuentas");
		CuentasWrapper cuentasWrapper = new CuentasWrapper(crearCuentaList());
		ResponseEntity<?> response = template.postForEntity(uri, cuentasWrapper, ResponseEntity.class);
		
		LOGGER.info("REST: Response status code: " + response.getStatusCode());
		
		context.close();
	}
	
	private static List<Cuenta> crearCuentaList() {
		List<Cuenta> cuentaList = new ArrayList<Cuenta>();
		long time = new Date().getTime();
		for (int i = 0; i<LIST_SIZE; i++) {
			Cuenta cuenta = new Cuenta();
			cuenta.setApellido("apellido_" + time + i);
			cuenta.setEmail("email_" + time + i);
			cuenta.setFcreacion(new Date());
			cuenta.setIdUsuario("id_" + time + i);
			cuenta.setNombre("nombre_" + time + i);
			cuenta.setPassword("password_" + time + i);
			cuenta.setTelefono(943112233);
			
			Perfil perfil = new Perfil();
			perfil.setIdioma(Idioma.INGLES);
			cuenta.setPerfil(perfil);
			
			cuentaList.add(cuenta);
		}
		
		return cuentaList;
		
	}

}
