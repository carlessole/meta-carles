require recipes-core/images/core-image-base.bb

DESCRIPTION = "Imatge personalitzada amb Hello World"
LICENSE = "MIT"

IMAGE_INSTALL:append = " hello"