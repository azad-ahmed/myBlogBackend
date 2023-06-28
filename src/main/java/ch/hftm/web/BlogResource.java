package ch.hftm.web;


import ch.hftm.model.Blog;
import ch.hftm.service.BlogService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import javax.validation.Valid;
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
    public Response createBlog(@Valid Blog.BlogCreateDto createDto, @Context UriInfo uriInfo) {
        Blog blog = new Blog("user", createDto.title(), createDto.content());
        blogService.addBlog(blog);

        return Response
                .created(uriInfo.getAbsolutePathBuilder().path(blog.getId().toString()).build())
                .entity(blog)
                .build();
    }
    @PUT
    @Path("/{id}")
    public Response updateBlog(@PathParam("id") long id, Blog.BlogCreateDto updateDto) {
        Blog blog = blogService.updateBlog(id, updateDto);
        return Response.ok(new Blog.BlogAllDto(
                blog.getId(),
                blog.getTitle(),
                blog.getContent(),
                blog.getAuthor()
        )).build();
    }
    @PATCH
    @Path("/{id}")
    public Response partialUpdateBlog(@PathParam("id") long id, Blog.BlogCreateDto updateDto) {
        Blog updatedBlog = blogService.partialUpdateBlog(id, updateDto);
        if (updatedBlog != null) {
            return Response.ok(new Blog.BlogAllDto(
                    updatedBlog.getId(),
                    updatedBlog.getTitle(),
                    updatedBlog.getContent(),
                    updatedBlog.getAuthor()
            )).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @DELETE
    @Path("/{id}")
    public Response deleteBlog(@PathParam("id")long id) {
        if (blogService.deleteBlog(id)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
