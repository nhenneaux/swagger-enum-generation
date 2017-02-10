package nhenneaux.test.endpoint.resource;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import nhenneaux.test.endpoint.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Api("hello")
@Path("/helloSwagger")
public class HelloSwagger {

    @ApiOperation(value = "Get all unique customers", notes = "Get all customers matching the given search string.", responseContainer = "Set", response = User.class)
    @GET
    @Path("/getUniqueUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<User> getUniqueUsers(
            @ApiParam(value = "The search string is used to find customer by their name. Not case sensitive.") @QueryParam("search") String searchString,
            @ApiParam(value = "Limits the size of the result set", defaultValue = "50") @QueryParam("limit") int limit
    ) {
        return new HashSet<>(Arrays.asList(new User(), new User()));
    }

}