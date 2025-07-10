SUMMARY = "Hello World C++ App"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello/hello.cpp"

S = "${WORKDIR}/hello"

do_compile() {
    ${CXX} ${CXXFLAGS} hello.cpp -o hello ${LDFLAGS}
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 hello ${D}${bindir}/hello
}
