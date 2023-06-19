package ch.hftm;

import io.smallrye.common.constraint.NotNull;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;

@ApplicationScoped
@Path("blog")
public class BlogResource {

    @Inject
    private BlogService blogService;

    @GET
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }

    @POST
    public Response createBlog(Blog.BlogCreateDto createDto, @Context UriInfo uriInfo) {
        Blog blog = new Blog("user", createDto.title(), createDto.content());
        blogService.addBlog(blog);

        return Response
                .created(uriInfo.getAbsolutePathBuilder().path(blog.getId().toString()).build())
                .entity(blog)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBlog(long id) {
        if (blogService.deleteBlog(id)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
