package edu.umss.dip.tiendalinea.dto;

import edu.umss.dip.tiendalinea.model.Foto;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;

public class FotoDto extends DtoBase<Foto> {
    private String image;
    private long idEquipo;

    public long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public FotoDto toDto(Foto foto, ModelMapper mapper) {
        super.toDto(foto, mapper);
        if (foto.getImage() != null) {
            byte[] bytes = new byte[foto.getImage().length];
            for (int i = 0; i < foto.getImage().length; i++) {
                bytes[i] = foto.getImage()[i];
            }
            String imageStr = Base64.encodeBase64String(bytes);
            setImage(imageStr);
        }
        return this;
    }
}
