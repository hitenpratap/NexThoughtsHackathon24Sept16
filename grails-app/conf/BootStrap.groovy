class BootStrap {

    def bootstrapService

    def init = { servletContext ->

      bootstrapService.createLabels()
    }

    def destroy = {
    }
}
