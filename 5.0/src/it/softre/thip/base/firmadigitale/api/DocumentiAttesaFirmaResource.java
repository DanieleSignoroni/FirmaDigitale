package it.softre.thip.base.firmadigitale.api;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thera.thermfw.rs.BaseResource;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 04/06/2024
 * <br><br>
 * <b>71XXX	DSSOF3	04/06/2024</b>
 * <p>Prima stesura.<br>
 *  
 * </p>
 */

@Path("/firmaDigitale/documenti/attesaFirma")
@PermitAll
public class DocumentiAttesaFirmaResource extends BaseResource {

	private static DocumentiAttesaFirmaService service = DocumentiAttesaFirmaService.getInstance();

	@GET
	@Path("/recupera")
	public Response recuperaDocumentiInAttesaDiFrima(@QueryParam("IdDevice") String idDevice,@QueryParam("IdAzienda") String idAzienda) {
		JSONObject infoDocumento = service.recuperaDocumentoDaFirmare(idDevice, idAzienda);
		if(infoDocumento.isEmpty()) {
			return buildResponse(Status.OK,infoDocumento.put("info", "Nessun documento").toString());
		}
		String encodedFile = Base64.getEncoder().encodeToString((byte[]) infoDocumento.get("file"));

		Map<String, Object> jsonResponse = new HashMap<String,Object>();
		jsonResponse.put("file", encodedFile);
		jsonResponse.put("info", infoDocumento.get("chiaveDocumentoDigitale"));

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String jsonString = objectMapper.writeValueAsString(jsonResponse);
			return Response.ok(jsonString).build();
		} catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving document").build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/firma")
	public Response firmaDocumento(String jsonString) {
		JSONObject response = service.firmaDocumento(jsonString);
		return buildResponse((StatusType) response.get("status"));

	}
}
