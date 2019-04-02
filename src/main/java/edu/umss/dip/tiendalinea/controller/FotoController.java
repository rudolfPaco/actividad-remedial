package edu.umss.dip.tiendalinea.controller;

import edu.umss.dip.tiendalinea.dto.FotoDto;
import edu.umss.dip.tiendalinea.model.Foto;
import edu.umss.dip.tiendalinea.service.FotoService;
import edu.umss.dip.tiendalinea.service.GenericService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

@Controller
@Path("/fotos")
@Produces(MediaType.APPLICATION_JSON)
public class FotoController extends GenericController<Foto, FotoDto> {
    private FotoService fotoService;

    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

    @Override
    @GET
    public List<FotoDto> getAll() {
        return super.getAll();
    }

    @Path("/{id}")
    @GET
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public List<FotoDto> getAllFotosEquipo(@PathParam(value = "id") String id) {
        return StringUtils.isEmpty(id) ? toDto(fotoService.findAll()) : toDto(fotoService.fotosEquipo(Long.valueOf(id)));
    }

    @Override
    protected GenericService getService() {
        return fotoService;
    }


    @Path("/{id}/image")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(@PathParam("id") String id,
                               @FormDataParam("file") InputStream file,
                               @FormDataParam("file") FormDataContentDisposition fileDisposition) {
        fotoService.saveImage(Long.valueOf(id), file);
        return Response.ok("se subio la foto exitosamente !!").build();
    }
}
