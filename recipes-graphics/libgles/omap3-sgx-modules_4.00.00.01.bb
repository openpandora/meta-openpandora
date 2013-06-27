DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap3 SoCs, nokia version"
LICENSE = "GPLv2"

PR ="r3"

LIC_FILES_CHKSUM="file://pvr/COPYING;md5=a012d2cd535123cb36c0fb16763c13df"

inherit module

MACHINE_KERNEL_PR_append = "i"

SRCREV = "cb0a07679533181d0d86ca2709f168b73d85cf62"
SRC_URI = " \
           git://git.openpandora.org/sgx.git;protocol=git;branch=nokia \
"          

S = "${WORKDIR}/git"
MAKE_TARGETS = " KERNELDIR=${STAGING_KERNEL_DIR} "

do_install() {
	mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
	cp ${S}/pvr/pvrsrvkm.ko \
	   ${S}/pvr/omaplfb.ko  \
	   ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}
