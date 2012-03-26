DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap3 SoCs"
LICENSE = "GPLv2"

PR ="r1"

LIC_FILES_CHKSUM="file://COPYING;md5=21228a42e27d1d104b31a83f7c9da935"

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"
require ti-eula-unpack.inc

SGXPV = "4_00_00_01"
IMGPV = "1.4.14.2616"
BINFILE := "Graphics_SDK_setuplinux_${SGXPV}.bin"

inherit module

MACHINE_KERNEL_PR_append = "i"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/${SGXPV}/exports/Graphics_SDK_setuplinux_${SGXPV}.bin \
           file://0002-Compile-fixes-for-recent-kernels.patch;patch=1 \
           file://0001-OMAP3-SGX-TI-4.00.00.01-2.6.37-rc1-use-semaphore-ove.patch;patch=1 \
           file://fix-2.6.27.patch;patch=1 \
           file://spinlock_3430.patch;patch=1 \
           file://compile-against-3.2.1.patch;patch=1 \
           file://fix-makefile.patch;patch=1 \
"

SRC_URI[md5sum] = "a027002dcd7164df467b1a315788d5fd"
SRC_URI[sha256sum] = "62383d15e33adf9349afba063b0f2405a15aa6c4b0b5579b0abdf81db7580df7"

S = "${WORKDIR}/Graphics_SDK_${SGXPV}/GFX_Linux_KM"

PVRBUILD = "release"

PACKAGE_STRIP = "no"

TI_PLATFORM_omap3-pandora = "omap3430"
#TI_PLATFORM_omap3 = "omap3630"
TI_PLATFORM_ti816x = "ti8168"

MODULESLOCATION_omap3 = "dc_omap3430_linux"
MODULESLOCATION_ti816x = "dc_ti8168_linux"

MAKE_TARGETS = " BUILD=${PVRBUILD} TI_PLATFORM=${TI_PLATFORM}"

do_install() {
	mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
	cp ${S}/pvrsrvkm.ko \
	   ${S}/services4/3rdparty/${MODULESLOCATION}/omaplfb.ko  \
	   ${S}/services4/3rdparty/bufferclass_ti/bufferclass_ti.ko \
	   ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}
