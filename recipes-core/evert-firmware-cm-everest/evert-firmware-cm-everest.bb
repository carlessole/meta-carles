LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "gitsm://git@github.com/InSol-Tech/firmware-cm-everest.git;branch=feat/PMU-369;protocol=ssh"
SRCREV = "08ae438e2493be5184f1d51c535651499332584c"

inherit cmake

S = "${WORKDIR}/git"

DEPENDS = " \
    evcli-native \
    everest-cmake \
    everest-core \
    everest-framework \
    libocpp \
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

    install -d ${D}${sysconfdir}/evert-firmware-cm-everest
    cp -r ${S}/config/runconfig/*.yaml ${D}${sysconfdir}/evert-firmware-cm-everest/
}