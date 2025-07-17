LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "gitsm://git@github.com/InSol-Tech/firmware-cm-everest.git;branch=main;protocol=ssh"
SRCREV = "2f79fbfea18c711ce8f6b1c7e707b6a444010359"

inherit cmake

S = "${WORKDIR}/git"

DEPENDS += " \
    pkgconfig-native \
    evcli-native \
    everest-cmake \
    everest-core \
    everest-framework \
    libocpp \
    libnfc \
"

FILES:${PN} += "\
    ${datadir}/everest/* \
    ${sysconfdir}/evert-firmware-cm-everest \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += " \
    -DDISABLE_EDM=ON \
    -DNO_FETCH_CONTENT=ON \
    -DEVEREST_ENABLE_RUN_SCRIPT_GENERATION=OFF \
    -DEVEREST_PROJECT_DIRS:STRING=${STAGING_DIR_TARGET}/usr/share/everest/ \
    -Deverest-evert_USE_PYTHON_VENV=OFF \
    -DCMAKE_SKIP_RPATH=TRUE \
"

do_install:append() {
    rm ${D}${datadir}/everest/version_information.txt

    install -d ${D}${sysconfdir}/evert-firmware-cm-everest/config/runconfig
    cp -r ${S}/config/runconfig/yocto/*.yaml ${D}${sysconfdir}/evert-firmware-cm-everest/config/runconfig

    install -d ${D}${sysconfdir}/evert-firmware-cm-everest/config/logs
    cp -r ${S}/config/logs/logging.cfg ${D}${sysconfdir}/evert-firmware-cm-everest/config/logs
}