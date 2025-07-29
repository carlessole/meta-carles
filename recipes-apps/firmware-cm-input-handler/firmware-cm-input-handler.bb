DESCRIPTION = "Input handler standalone C++ application for Communication Module"
HOMEPAGE = "https://github.com/InSol-Tech/firmware-cm-input-handler"
## TODO: Add LICENSE when it is available
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/InSol-Tech/firmware-cm-input-handler.git;branch=main;protocol=https"
SRCREV = "1ef3ca62803b616402a2b8ce9196ca54be128a64"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

DEPENDS = "libnfc paho-mqtt-cpp yaml-cpp nlohmann-json"

RDEPENDS:${PN} += "mosquitto"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

# Instal the binary to /usr/bin (done by CMake) and the config file to /etc/evert/firmware-cm-input-handler
do_install:append() {
    install -d ${D}${sysconfdir}/evert/firmware-cm-input-handler
    install -m 0644 ${S}/config/config.yaml ${D}${sysconfdir}/evert/firmware-cm-input-handler/config.yaml
}

# Ensure the binary and config file are included in the package (.deb, -rpm...)
FILES:${PN} += "${bindir}/*"
FILES:${PN} += "${sysconfdir}/evert/firmware-cm-input-handler/config.yaml"
