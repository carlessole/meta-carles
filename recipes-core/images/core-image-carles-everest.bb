require recipes-core/images/core-image-base.bb

DESCRIPTION = "Custom Image by Carles with EVerest running"
LICENSE = "MIT"

IMAGE_INSTALL:append = " os-release hello everest-core mosquitto"