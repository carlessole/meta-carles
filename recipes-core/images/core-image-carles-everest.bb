require recipes-core/images/core-image-base.bb

DESCRIPTION = "Custom Image by Carles with EVerest running"
LICENSE = "MIT"

IMAGE_INSTALL:append = " \
    coreutils \
    curl \
    htop \
    i2c-tools \
    init-ifupdown \
    iw \
    haveged \
    kernel-modules \
    nano \
    rng-tools \
    wpa-supplicant \
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-core-ssh-openssh \
    os-release \
    hello \
    can-utils \
    everest-core \
    evert-firmware-cm-everest \
    libocpp \
    everest-admin-panel \
    firmware-cm-input-handler \
    tzdata \
    libnfc \
    mosquitto"