DESCRIPTION = "Tool to sign omap3 x-loader images"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r1"

SRC_URI = "file://signGP.c"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/signGP.c -o signGP
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 signGP ${D}${bindir}
}

NATIVE_INSTALL_WORKS = "1"

BBCLASSEXTEND = "native"
