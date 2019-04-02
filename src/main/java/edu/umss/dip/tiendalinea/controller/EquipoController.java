package edu.umss.dip.tiendalinea.controller;

import edu.umss.dip.tiendalinea.dto.EquipoDto;
import edu.umss.dip.tiendalinea.model.Equipo;
import edu.umss.dip.tiendalinea.service.EquipoService;
import edu.umss.dip.tiendalinea.service.GenericService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

@Controller
@Path("/equipos")
@Produces(MediaType.APPLICATION_JSON)
public class EquipoController extends GenericController<Equipo, EquipoDto> {

    private EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @Override
    @GET
    public List<EquipoDto> getAll() {
        return super.getAll();
    }

    @PUT
    @Path("/update/estado")
    public EquipoDto update(@RequestBody EquipoDto element) {
        EquipoDto equipoDto = element;
        equipoService.actualizarEstado(toModel(equipoDto));
        return equipoDto;
    }

    @Path("/{id}/image")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(@PathParam("id") String id,
                               @FormDataParam("file") InputStream file,
                               @FormDataParam("file") FormDataContentDisposition fileDisposition) {
        equipoService.saveImage(Long.valueOf(id), file);
        return Response.ok("Data uploaded successfully !!").build();
    }


    @Override
    protected GenericService getService() {
        return equipoService;
    }
}
