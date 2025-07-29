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
    vcan-systemd \
    tzdata \
    libnfc \
    wifi-config \
    wifi-connect \
    mosquitto"

# Enable automatic SSH service if systemd is in use
SYSTEMD_AUTO_ENABLE:append = " sshd.service"
SYSTEMD_SERVICE:append = " sshd.service"

# Optional: allow root login without password (for development only!)
EXTRA_IMAGE_FEATURES += "debug-tweaks"