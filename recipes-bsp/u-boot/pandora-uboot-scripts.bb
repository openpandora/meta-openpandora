DESCRIPTION = "Helper uboot boot scripts for the OpenPandora"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

DEPENDS = "u-boot-mkimage-native"

SRC_URI = " \
	file://boot* \
"

PR = "r5"

do_configure() {
	cp ${WORKDIR}/boot* ${S}
}

do_compile() {
	for i in boot* ; do
		uboot-mkimage -A ${TARGET_ARCH} -O linux -T script -C none -a 0 -e 0 -n "OpenPandora $i" -d $i $i.scr
	done
}

do_install() {
	install -d ${D}/boot/u-boot-scripts
	for i in *.scr ; do
		install -m 0644 $i ${D}/boot/u-boot-scripts
	done
}

FILES_${PN} += "/boot"

addtask deploy before do_package after do_install

do_deploy() {
	install -d ${DEPLOY_DIR_IMAGE}
	for i in *.scr ; do
		cp $i ${DEPLOY_DIR_IMAGE}
	done
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
