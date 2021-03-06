package io.bootique.bom.linkrest.r1;

import com.nhl.link.rest.DataResponse;
import com.nhl.link.rest.LinkRest;
import com.nhl.link.rest.SelectStage;
import io.bootique.bom.linkrest.ITEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Arrays;

@Path("/lr1")
@Produces(MediaType.APPLICATION_JSON)
public class LrResource1 {

    @Context
    private Configuration config;

    @GET
    public DataResponse<ITEntity> get(UriInfo info) {
        return LinkRest.select(ITEntity.class, config)
                .uri(info)
                .terminalStage(SelectStage.APPLY_SERVER_PARAMS, context -> {
                    ITEntity e1 = new ITEntity();
                    e1.setId(5);
                    e1.setName("name5");

                    ITEntity e2 = new ITEntity();
                    e2.setId(6);
                    e2.setName("name6");

                    context.setObjects(Arrays.asList(e1, e2));
                })
                .get();
    }
}
