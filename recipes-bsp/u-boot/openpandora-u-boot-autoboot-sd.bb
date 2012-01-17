DESCRIPTION = "Helper U-Boot text script for the OpenPandora when booting from SD"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

DEPENDS = "u-boot"

SRC_URI = " \
	file://autoboot.txt \
"

PR = "r1"

do_configure() {
	cp ${WORKDIR}/autoboot.txt ${S}
}

do_compile() {
}

do_install() {
	install -d ${D}/
	for i in *.txt ; do
		install -m 0644 $i ${D}/
	done
}

FILES_${PN} += "/*.txt"

PACKAGE_ARCH = "${MACHINE_ARCH}"
